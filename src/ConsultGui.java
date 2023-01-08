import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsultGui implements ActionListener {
    static JFrame frame;
    static JTable table;
    static JTable table1;
    static DefaultTableModel model;
    static JButton sortButton;
    static JButton windowButton;
    static ArrayList<Doctor> guiDoctors;
    static DefaultTableModel tableModel;
    static JPanel bookingPanel;
    static JLabel bookingLabel;
    static JLabel nameLabel;
    static JLabel surNameLabel;
    static JLabel birthLabel;
    static JLabel contactLabel;
    static JLabel idLabel;
    static JLabel bookingDateLabel;
    static JTextField nameTextField;
    static JTextField surTextField;
    static JTextField birthTextField;
    static JTextField contactTextField;
    static JTextField idTextField;
    static JTextField bookingDateTextField;
    Font myFont = new Font("Arial", Font.BOLD, 14);


    public ConsultGui() {
        frame = new JFrame("Doctors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 800);
        frame.setLayout(null);

        String[] cols = {"Name", "Date of Birth", "Specialisation", "Contact Number", "License Number"};
        tableModel = new DefaultTableModel(cols, 0);
        table = new JTable(tableModel);
        tableModel.addRow(cols);
        for (Doctor doctor : WestminsterSkinConsultationManager.doctors) {
            Object[] data = {doctor.getName() + " " + doctor.getSurName(), doctor.getBirth(), doctor.getSpecialisation(), doctor.getContactNum(), doctor.getLicenseNum()};
            tableModel.addRow(data);
        }


        JTableHeader jTableHeader = table.getTableHeader();
        table.setFont(myFont);
        table.setBounds(10, 30, 600, 300);
        table.setEnabled(false);

        bookingLabel = new JLabel("Doctor Consultation");
        bookingLabel.setBounds(150, 330, 200, 40);

        nameLabel = new JLabel("First Name:");
        surNameLabel = new JLabel("SurName:");
        birthLabel = new JLabel("Date of Birth:");
        contactLabel = new JLabel("Contact Number:");
        idLabel = new JLabel("ID Number:");

        nameTextField = new JTextField(40);
        surTextField = new JTextField(40);
        birthTextField = new JTextField(40);
        contactTextField = new JTextField(40);
        idTextField = new JTextField(40);

        bookingPanel = new JPanel();
        bookingPanel.setFont(myFont);
        bookingPanel.setBounds(100, 370, 400, 300);
        bookingPanel.setLayout(new GridLayout(5, 2, 5, 5));

        ImageIcon sorting = new ImageIcon("C:\\Users\\nimasha\\Pictures\\pics\\sort.jpg");
        Image sortImage = sorting.getImage();
        Image modifiedSorting = sortImage.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        sorting = new ImageIcon(modifiedSorting);
        sortButton = new JButton();
        sortButton.setText("SORT");
        sortButton.setIcon(sorting);
        sortButton.setBounds(150, 280, 150, 50);
        sortButton.setBackground(Color.cyan);
        sortButton.addActionListener(this::actionPerformed);

        windowButton =  new JButton("Doctor Calender");
        windowButton.setBounds(300, 280, 200, 50);
        windowButton.addActionListener(this::actionPerformed);

        bookingPanel.add(nameLabel);
        bookingPanel.add(nameTextField);
        bookingPanel.add(surNameLabel);
        bookingPanel.add(surTextField);
        bookingPanel.add(birthLabel);
        bookingPanel.add(birthTextField);
        bookingPanel.add(contactLabel);
        bookingPanel.add(contactTextField);
        bookingPanel.add(idLabel);
        bookingPanel.add(idTextField);

        frame.add(windowButton);
        frame.add(sortButton);
        frame.add(bookingPanel);
        frame.add(bookingLabel);
        frame.add(table);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sortButton) {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(1);
            Collections.sort(WestminsterSkinConsultationManager.doctors, Doctor.surNameComparator);
            for (Doctor doctor : WestminsterSkinConsultationManager.doctors) {
                Object[] data = {doctor.getName() + " " + doctor.getSurName(), doctor.getBirth(), doctor.getSpecialisation(), doctor.getContactNum(), doctor.getLicenseNum()};
                tableModel.addRow(data);
            }
        }
        if (e.getSource() == windowButton){
            new CalendarPage();
        }
    }
}

