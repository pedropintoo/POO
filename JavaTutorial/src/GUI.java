import javax.swing.JOptionPane;
public class GUI {
    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog("Enter your Name"); // (message)
        //JOptionPane.showMessageDialog(null, "Hello "+name); // (parentComponent,message)

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age")); // showInputDialog() Devolve uma string!
        //JOptionPane.showMessageDialog(null,"You are "+age+" year old");

        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height")); // showInputDialog() Devolve uma string!
        //JOptionPane.showMessageDialog(null,"You are "+height+" cm tall");
        JOptionPane.showMessageDialog(null,
                                             "Hi "+name+"!" +
                                                     " You are "+age+" years old " +
                                                     "and "+height+" cm tall");
    }
}
