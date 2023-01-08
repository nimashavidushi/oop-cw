import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CalendarPage implements ActionListener {
    static JFrame frame1;
    static JTable table1;
    static DefaultTableModel model;
    static JPanel consultPanel;
    static JLabel docName;
    static JLabel bookDate;
    static JLabel bookTime;
    static JTextField nameOfDoc;
    static JTextField bookingDate;
    static JTextField bookingTime;
    static JLabel availableLabel;
    static JButton checkButton;
    static JButton bookButton;
    static JButton noteButton;
    static JPanel infoPanel;
    static JLabel nameLabel;
    static JLabel surNameLabel;
    static JLabel birthLabel;
    static JLabel contactLabel;
    static JLabel idLabel;
    static JLabel noteLabel;
    static JTextField nameTextField;
    static JTextField surTextField;
    static JTextField birthTextField;
    static JTextField contactTextField;
    static JTextField idTextField;
    static JTextField noteTextField;





    CalendarPage(){
        frame1 = new JFrame("Calendar");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(2000, 800);
        frame1.setLayout(null);

        String[] cols = {"Monday \n Morning", "Monday Evening", "Tuesday Morning", "Tuesday Evening", "Wednesday Morning", "Wednesday Evening", "Thursday Morning", "Thursday Evening", "Friday Morning", "Friday Evening", "Saturday Morning", "Saturday Evening", "Sunday Morning", "Sunday Evening"};
        model = new DefaultTableModel(cols, 0);
        table1 = new JTable(model);
        model.addRow(cols);
        model.addRow(new Object[]{null});
        for (int i = 0; i<WestminsterSkinConsultationManager.MonMor.size(); i++) {
            String element = WestminsterSkinConsultationManager.MonMor.get(i);
            model.setValueAt(element,i+1,0);
            model.addRow(new Object[]{null});
        }
        for (int i = 0; i<WestminsterSkinConsultationManager.MonEve.size(); i++) {
            String element1 = WestminsterSkinConsultationManager.MonEve.get(i);
            model.setValueAt(element1,i+1,1);
            model.addRow(new Object[]{null});
        }
        for (int i = 0; i<WestminsterSkinConsultationManager.TueMor.size(); i++) {
            String element2 = WestminsterSkinConsultationManager.TueMor.get(i);
            model.setValueAt(element2,i+1,2);
            model.addRow(new Object[]{null});
        }
        for (int i = 0; i<WestminsterSkinConsultationManager.TueEve.size(); i++) {
            String element3 = WestminsterSkinConsultationManager.TueEve.get(i);
            model.setValueAt(element3,i+1,3);
            model.addRow(new Object[]{null});
        }
        for (int i = 0; i<WestminsterSkinConsultationManager.WedMor.size(); i++) {
            String element4 = WestminsterSkinConsultationManager.WedMor.get(i);
            model.setValueAt(element4,i+1,4);
            model.addRow(new Object[]{null});
        }
        for (int i = 0; i<WestminsterSkinConsultationManager.WedEve.size(); i++) {
            String element5 = WestminsterSkinConsultationManager.WedEve.get(i);
            model.setValueAt(element5,i+1,5);
            model.addRow(new Object[]{null});
        }
        for (int i = 0; i<WestminsterSkinConsultationManager.ThuMor.size(); i++) {
            String element6 = WestminsterSkinConsultationManager.ThuMor.get(i);
            model.setValueAt(element6,i+1,6);
            model.addRow(new Object[]{null});
        }
        for (int i = 0; i<WestminsterSkinConsultationManager.ThuEve.size(); i++) {
            String element7 = WestminsterSkinConsultationManager.ThuEve.get(i);
            model.setValueAt(element7,i+1,7);
            model.addRow(new Object[]{null});
        }
        for (int i = 0; i<WestminsterSkinConsultationManager.FriMor.size(); i++) {
            String element8 = WestminsterSkinConsultationManager.FriMor.get(i);
            model.setValueAt(element8,i+1,8);
            model.addRow(new Object[]{null});
        }
        for (int i = 0; i<WestminsterSkinConsultationManager.FriEve.size(); i++) {
            String element9 = WestminsterSkinConsultationManager.FriEve.get(i);
            model.setValueAt(element9,i+1,9);
            model.addRow(new Object[]{null});
        }
        for (int i = 0; i<WestminsterSkinConsultationManager.SatMor.size(); i++) {
            String element10 = WestminsterSkinConsultationManager.SatMor.get(i);
            model.setValueAt(element10,i+1,10);
            model.addRow(new Object[]{null});
        }
        for (int i = 0; i<WestminsterSkinConsultationManager.SatEve.size(); i++) {
            String element11 = WestminsterSkinConsultationManager.SatEve.get(i);
            model.setValueAt(element11,i+1,11);
            model.addRow(new Object[]{null});
        }
        for (int i = 0; i<WestminsterSkinConsultationManager.SunMor.size(); i++) {
            String element12 = WestminsterSkinConsultationManager.SunMor.get(i);
            model.setValueAt(element12,i+1,12);
            model.addRow(new Object[]{null});
        }
        for (int i = 0; i<WestminsterSkinConsultationManager.SunEve.size(); i++) {
            String element13 = WestminsterSkinConsultationManager.SunEve.get(i);
            model.setValueAt(element13,i+1,13);
            model.addRow(new Object[]{null});
        }
        table1.setBounds(10, 30, 1500, 300);
        table1.setEnabled(false);

        consultPanel = new JPanel();
        consultPanel.setBounds(5, 400, 800, 200);
        consultPanel.setLayout(new GridLayout(5, 2, 5, 5));

        infoPanel = new JPanel();
        infoPanel.setBounds(805,400,650,200);
        infoPanel.setLayout(new GridLayout(6,2,5,5));
        infoPanel.setVisible(false);

        docName = new JLabel("Enter the first name of the doctor to book:");
        bookDate = new JLabel("Enter date to book:");
        bookTime = new JLabel("Enter time to book:");

        nameOfDoc = new JTextField();
        bookingDate = new JTextField();
        bookingTime = new JTextField();

        availableLabel = new JLabel();

        nameLabel = new JLabel("First Name:");
        surNameLabel = new JLabel("SurName:");
        birthLabel = new JLabel("Date of Birth:");
        contactLabel = new JLabel("Contact Number:");
        idLabel = new JLabel("ID Number:");
        noteLabel = new JLabel("Description");

        nameTextField = new JTextField(40);
        surTextField = new JTextField(40);
        birthTextField = new JTextField(40);
        contactTextField = new JTextField(40);
        idTextField = new JTextField(40);
        noteTextField = new JTextField(40);



        noteButton = new JButton("Upload Image");

        checkButton = new JButton("CHECK");
        checkButton.addActionListener(this::actionPerformed);

        bookButton = new JButton("Book Doctor");
        bookButton.addActionListener(this::actionPerformed);

        noteTextField.add(noteButton);
        infoPanel.add(nameLabel);
        infoPanel.add(nameTextField);
        infoPanel.add(surNameLabel);
        infoPanel.add(surTextField);
        infoPanel.add(birthLabel);
        infoPanel.add(birthTextField);
        infoPanel.add(contactLabel);
        infoPanel.add(contactTextField);
        infoPanel.add(idLabel);
        infoPanel.add(idTextField);
        infoPanel.add(noteLabel);
        infoPanel.add(noteTextField);


        consultPanel.add(checkButton);
        consultPanel.add(availableLabel);
        consultPanel.add(docName);
        consultPanel.add(nameOfDoc);
        consultPanel.add(bookDate);
        consultPanel.add(bookingDate);
        consultPanel.add(bookTime);
        consultPanel.add(bookingTime);
        consultPanel.add(bookButton);

        frame1.add(infoPanel);
        frame1.add(consultPanel);
        frame1.add(table1);
        frame1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==checkButton){
            String doc = nameOfDoc.getText().toLowerCase();
            String day = bookingDate.getText();
            LocalDate date = LocalDate.parse(day);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            String myDay = dayOfWeek.toString().toLowerCase();
            String time = bookingTime.getText().toLowerCase();
            if(myDay.equals("monday") && time.equals("morning")){
                if (WestminsterSkinConsultationManager.MonMor.contains(doc)){
                    availableLabel.setText("Doctor is available");
                }
                else {
                    Random random = new Random();
                    int index = random.nextInt(WestminsterSkinConsultationManager.MonMor.size());
                    availableLabel.setText(WestminsterSkinConsultationManager.MonMor.get(index)+" will be placed");
                }
            }
            if(myDay.equals("monday") && time.equals("evening")){
                if (WestminsterSkinConsultationManager.MonEve.contains(doc)){
                    availableLabel.setText("Doctor is available");
                }
                else {
                    Random random = new Random();
                    int index = random.nextInt(WestminsterSkinConsultationManager.MonEve.size());
                    availableLabel.setText(WestminsterSkinConsultationManager.MonEve.get(index)+" will be placed");
                }
            }
            if(myDay.equals("tuesday") && time.equals("morning")){
                if (WestminsterSkinConsultationManager.TueMor.contains(doc)){
                    availableLabel.setText("Doctor is available");
                }
                else {
                    Random random = new Random();
                    int index = random.nextInt(WestminsterSkinConsultationManager.TueMor.size());
                    availableLabel.setText(WestminsterSkinConsultationManager.TueMor.get(index)+" will be placed");
                }
            }
            if(myDay.equals("tuesday") && time.equals("evening")){
                if (WestminsterSkinConsultationManager.TueEve.contains(doc)){
                    availableLabel.setText("Doctor is available");
                }
                else {
                    Random random = new Random();
                    int index = random.nextInt(WestminsterSkinConsultationManager.TueEve.size());
                    availableLabel.setText(WestminsterSkinConsultationManager.TueEve.get(index)+" will be placed");
                }
            }
            if(myDay.equals("wednesday") && time.equals("morning")){
                if (WestminsterSkinConsultationManager.WedMor.contains(doc)){
                    availableLabel.setText("Doctor is available");
                }
                else {
                    Random random = new Random();
                    int index = random.nextInt(WestminsterSkinConsultationManager.WedMor.size());
                    availableLabel.setText(WestminsterSkinConsultationManager.WedMor.get(index)+" will be placed");
                }
            }
            if(myDay.equals("wednesday") && time.equals("evening")){
                if (WestminsterSkinConsultationManager.WedEve.contains(doc)){
                    availableLabel.setText("Doctor is available");
                }
                else {
                    Random random = new Random();
                    int index = random.nextInt(WestminsterSkinConsultationManager.WedEve.size());
                    availableLabel.setText(WestminsterSkinConsultationManager.WedEve.get(index)+" will be placed");
                }
            }
            if(myDay.equals("thursday") && time.equals("morning")){
                if (WestminsterSkinConsultationManager.ThuMor.contains(doc)){
                    availableLabel.setText("Doctor is available");
                }
                else {
                    Random random = new Random();
                    int index = random.nextInt(WestminsterSkinConsultationManager.ThuMor.size());
                    availableLabel.setText(WestminsterSkinConsultationManager.ThuMor.get(index)+" will be placed");
                }
            }
            if(myDay.equals("thursday") && time.equals("evening")){
                if (WestminsterSkinConsultationManager.ThuEve.contains(doc)){
                    availableLabel.setText("Doctor is available");
                }
                else {
                    Random random = new Random();
                    int index = random.nextInt(WestminsterSkinConsultationManager.ThuEve.size());
                    availableLabel.setText(WestminsterSkinConsultationManager.ThuEve.get(index)+" will be placed");
                }
            }
            if(myDay.equals("friday") && time.equals("morning")){
                if (WestminsterSkinConsultationManager.FriMor.contains(doc)){
                    availableLabel.setText("Doctor is available");
                }
                else {
                    Random random = new Random();
                    int index = random.nextInt(WestminsterSkinConsultationManager.FriMor.size());
                    availableLabel.setText(WestminsterSkinConsultationManager.FriMor.get(index)+" will be placed");
                }
            }
            if(myDay.equals("friday") && time.equals("evening")){
                if (WestminsterSkinConsultationManager.FriEve.contains(doc)){
                    availableLabel.setText("Doctor is available");
                }
                else {
                    Random random = new Random();
                    int index = random.nextInt(WestminsterSkinConsultationManager.FriEve.size());
                    availableLabel.setText(WestminsterSkinConsultationManager.FriEve.get(index)+" will be placed");
                }
            }
            if(myDay.equals("saturday") && time.equals("morning")){
                if (WestminsterSkinConsultationManager.SatMor.contains(doc)){
                    availableLabel.setText("Doctor is available");
                }
                else {
                    Random random = new Random();
                    int index = random.nextInt(WestminsterSkinConsultationManager.SatMor.size());
                    availableLabel.setText(WestminsterSkinConsultationManager.SatMor.get(index)+" will be placed");
                }
            }
            if(myDay.equals("saturday") && time.equals("evening")){
                if (WestminsterSkinConsultationManager.SatEve.contains(doc)){
                    availableLabel.setText("Doctor is available");
                }
                else {
                    Random random = new Random();
                    int index = random.nextInt(WestminsterSkinConsultationManager.SatEve.size());
                    availableLabel.setText(WestminsterSkinConsultationManager.SatEve.get(index)+" will be placed");
                }
            }
            if(myDay.equals("sunday") && time.equals("morning")){
                if (WestminsterSkinConsultationManager.SunMor.contains(doc)){
                    availableLabel.setText("Doctor is available");
                }
                else {
                    Random random = new Random();
                    int index = random.nextInt(WestminsterSkinConsultationManager.SunMor.size());
                    availableLabel.setText(WestminsterSkinConsultationManager.SunMor.get(index)+" will be placed");
                }
            }
            if(myDay.equals("sunday") && time.equals("evening")){
                if (WestminsterSkinConsultationManager.SunEve.contains(doc)){
                    availableLabel.setText("Doctor is available");
                }
                else {
                    Random random = new Random();
                    int index = random.nextInt(WestminsterSkinConsultationManager.SunEve.size());
                    availableLabel.setText(WestminsterSkinConsultationManager.SunEve.get(index)+" will be placed");
                }
            }
        }
        if (e.getSource()==bookButton){
            infoPanel.setVisible(true);
        }
    }
}
