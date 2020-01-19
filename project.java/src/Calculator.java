import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JTextField results;
    private JButton muliplybtn;
    private JButton no8btn;
    private JButton no7btn;
    private JButton dividebtn;
    private JButton plusbtn;
    private JButton no9btn;
    private JButton no6btn;
    private JButton no5btn;
    private JButton no4btn;
    private JButton no0btn;
    private JButton no3btn;
    private JButton no2btn;
    private JButton no1btn;
    private JButton minusbtn;
    private JButton equalsbtn;
    private JPanel calculatorview;
    private Double leftOperand;
    private Double rightOperand;
    private Operation calcOperation;


    private Calculator() {

        no0btn.addActionListener(new NumberBtnClicked(no0btn.getText()));
        no1btn.addActionListener(new NumberBtnClicked(no1btn.getText()));
        no2btn.addActionListener(new NumberBtnClicked(no2btn.getText()));
        no3btn.addActionListener(new NumberBtnClicked(no3btn.getText()));
        no4btn.addActionListener(new NumberBtnClicked(no4btn.getText()));
        no5btn.addActionListener(new NumberBtnClicked(no5btn.getText()));
        no6btn.addActionListener(new NumberBtnClicked(no6btn.getText()));
        no7btn.addActionListener(new NumberBtnClicked(no7btn.getText()));
        no8btn.addActionListener(new NumberBtnClicked(no8btn.getText()));
        no9btn.addActionListener(new NumberBtnClicked(no9btn.getText()));


        muliplybtn.addActionListener(new OperationBtnClicked(Operation.MULTIPLICATION));
        dividebtn.addActionListener(new OperationBtnClicked(Operation.DIVISION));
        minusbtn.addActionListener(new OperationBtnClicked(Operation.SUBTRACTION));
        plusbtn.addActionListener(new OperationBtnClicked(Operation.ADDITION));
        equalsbtn.addActionListener(new EqualBtnClicked());


    }

    private class NumberBtnClicked implements ActionListener {

        private String value;

        private NumberBtnClicked(String value) {
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(leftOperand == null || leftOperand == 0.0) {
                value = results.getText() + value;
            }else{
                rightOperand = Double.valueOf(value);
            }
            results.setText(value);

        }
    }

    private class OperationBtnClicked implements ActionListener {

        private Operation operation;

        private OperationBtnClicked(Operation operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            calcOperation = operation;
            leftOperand = Double.valueOf(results.getText());
        }
    }

    private class EqualBtnClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Double output = calcOperation.getOperator().applyAsDouble(leftOperand, rightOperand);
            results.setText(output%1==0?String.valueOf(output.intValue()):String.valueOf(output));
            leftOperand = 0.0;
            rightOperand = 0.0;
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().calculatorview);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}