package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    public OrderDTO createOrder(OrderDTO orderDTO);
    public List<OrderDTO> getAllOrders();
    public OrderDTO getOrderById(String orderId);
    public OrderDTO updateOrder(String orderId, OrderDTO orderDTO);
    public void deleteOrderById(String orderId);

}
