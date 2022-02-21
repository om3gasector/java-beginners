package com.company;
import java.util.stream.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {
    public static void main(String args[]) {
        JFrame win;
        JTable jt1, jt2;
        JLabel lbl1, lbl2, lbl3;
        JRadioButton rb1, rb2;
        JButton btn1, btn2;
        JTextArea ta;
        int[] A = new int[4];
        DefaultTableModel dtm1, dtm2;
        win = new JFrame("Определение отрицательных элементов и их суммы");
        lbl1 = new JLabel("Какаие элементы вывести?");
        lbl1.setBounds(25, 15, 200, 20);
        win.add(lbl1);
        rb1 = new JRadioButton("Отрицательные элементы");
        rb1.setBounds(20, 45, 150, 20);
        rb1.setSelected(true);
        win.add(rb1);
        rb2 = new JRadioButton("Сумма отр. элементов");
        rb2.setBounds(20, 65, 150, 20);
        win.add(rb2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        lbl2 = new JLabel("Введите элементы массива: ");
        lbl2.setBounds(225, 15, 200, 20);
        win.add(lbl2);
        dtm1 = new DefaultTableModel(1, 4);
        jt1 = new JTable(dtm1);
        jt1.setBounds(200, 40, 240, 20);
        win.add(jt1);
        lbl3 = new JLabel("Результат выполнения: ");
        lbl3.setBounds(200, 70, 200, 20);
        win.add(lbl3);
        ta = new JTextArea();
        ta.setBounds(200, 90, 240, 150);
        win.add(ta);
        btn1 = new JButton("Выполнить");
        btn1.setBounds(25, 130, 150, 25);
        win.add(btn1);
        btn2 = new JButton("Очистить");
        btn2.setBounds(25, 160, 150, 25);
        win.add(btn2);
        win.setSize(480, 300);
        win.setLayout(null);
        win.setVisible(true);

        rb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                win.setSize(480, 300);
                lbl2.setText("Введите элементы массива: ");
                jt1.setBounds(200, 40, 240, 20);
                jt1.setVisible(false);
                jt1.setVisible(true);
                win.add(jt1);
            }
        });
        rb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                win.setSize(480, 300);
                lbl2.setText("Введите элементы массива: ");
                jt1.setBounds(200, 40, 240, 20);
                jt1.setVisible(false);
                jt1.setVisible(true);
                win.add(jt1);
            }
        });

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i, sum = 0;
                ArrayList<Integer> ArrayList = new ArrayList<>();

                for (i = 0; i < jt1.getColumnCount(); i++)
                    A[i] = Integer.parseInt(jt1.getValueAt(0, i).toString());
                if (rb1.isSelected()) { //отрицательные
                    for (i = 0; i < jt1.getColumnCount(); i++) {
                        if (A[i] < 0) {
                            ArrayList.add(A[i]);
                        }
                    }
                    ta.append("Отрицательные: "+ ArrayList +"\n");
                }
                if (rb2.isSelected()) { //сумма
                    for (int ind = 0; ind < A.length ; ind++) {
                        if (A[ind] < 0) {
                            sum += A[ind];
                        }
                    }
                    ta.append("Сумма: "+ sum +"\n");
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rb1.isSelected())
                    for (int i = 0; i < jt1.getColumnCount(); i++)
                        jt1.setValueAt("", 0, i);
                else
                    for (int i = 0; i < jt1.getColumnCount(); i++)
                        jt1.setValueAt("", 0, i);
                ta.setText("");
            }
        });
    }
}
