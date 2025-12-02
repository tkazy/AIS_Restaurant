
package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RestaurantApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ресторан: бронирование или заказ");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 450);
            frame.setLayout(new BorderLayout(10, 10));

            JPanel switchPanel = new JPanel(new FlowLayout());
            JRadioButton bookingRadio = new JRadioButton("Бронирование");
            JRadioButton orderRadio = new JRadioButton("Заказ блюд");
            ButtonGroup group = new ButtonGroup();
            group.add(bookingRadio);
            group.add(orderRadio);
            bookingRadio.setSelected(true);
            switchPanel.add(bookingRadio);
            switchPanel.add(orderRadio);

            Map<String, Integer> tables = new HashMap<>();
            tables.put("Столик 1", 2);
            tables.put("Столик 2", 4);
            tables.put("Столик 3", 6);

            JLabel statusLabel = new JLabel("Выберите действие и заполните форму.");

            BookingPanel bookingPanel = new BookingPanel(tables, statusLabel);
            OrderPanel orderPanel = new OrderPanel(statusLabel);

            JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
            centerPanel.add(bookingPanel, BorderLayout.NORTH);
            centerPanel.add(orderPanel, BorderLayout.CENTER);

            frame.add(switchPanel, BorderLayout.NORTH);
            frame.add(centerPanel, BorderLayout.CENTER);
            frame.add(statusLabel, BorderLayout.PAGE_END);

            bookingRadio.addActionListener(e -> {
                bookingPanel.setVisible(true);
                orderPanel.setVisible(false);
                statusLabel.setText("Введите данные для бронирования.");
            });

            orderRadio.addActionListener(e -> {
                bookingPanel.setVisible(false);
                orderPanel.setVisible(true);
                statusLabel.setText("Выберите блюда для заказа.");
            });

            bookingPanel.setVisible(true);
            orderPanel.setVisible(false);

            frame.setVisible(true);
        });
    }
}
