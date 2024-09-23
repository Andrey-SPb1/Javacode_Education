package org.education.stream.products;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorsExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        // Группируйте заказы по продуктам.
        Map<String, List<Order>> groupByProduct = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct));

        // Для каждого продукта найдите общую стоимость всех заказов.
        Map<String, Double> totalCostByProduct = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct, Collectors.summingDouble(Order::getCost)));

        // Отсортируйте продукты по убыванию общей стоимости.
        List<Map.Entry<String, Double>> sortedProductsByTotalCost = totalCostByProduct.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .toList();

        // Выберите три самых дорогих продукта.
        List<Order> list = orders.stream()
                .sorted(Comparator.comparing(Order::getCost).reversed())
                .limit(3)
                .toList();

        // Выведите результат: список трех самых дорогих продуктов и их общая стоимость.
        list.stream()
                .map(Order::getProduct)
                .forEach(product ->
                        System.out.printf("Total cost for %s = %.2f\n", product, totalCostByProduct.get(product)));

    }
}