package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.OrderDTO;
import com.danieldjam.ecomer.models.entities.Order;
import com.danieldjam.ecomer.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        return convertEntityToDto(orderRepository.save(convertDtoToEntity(orderDTO)));
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        return orderList.stream().map(order -> mapEntityToDto(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(String orderId) {
        return mapEntityToDto(orderRepository.findById(Integer.parseInt(orderId)).get());
    }

    @Override
    public OrderDTO updateOrder(String orderId, OrderDTO orderDTO) {
        Order order = orderRepository.findById(Integer.parseInt(orderId)).get();
        order.setStatusOrder(orderDTO.getStatusOrder());
        order.setArrivalDate(orderDTO.getArrivalDate());
        order.setDepartureDate(orderDTO.getDepartureDate());
        order.setEstimatedDate(orderDTO.getEstimatedDate());
        order.setInitialLocation(orderDTO.getInitialLocation());
        order.setFinalLocation(orderDTO.getFinalLocation());
        return convertEntityToDto(orderRepository.save(order));
    }

    @Override
    public void deleteOrderById(String orderId) { orderRepository.deleteById(Integer.parseInt(orderId));}

    private OrderDTO convertEntityToDto(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    private Order convertDtoToEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }


    private OrderDTO mapEntityToDto(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setUserId(order.getUserId().getUserId());
        orderDTO.setArrivalDate(order.getArrivalDate());
        orderDTO.setEstimatedDate(order.getEstimatedDate());
        orderDTO.setDepartureDate(order.getDepartureDate());
        orderDTO.setFinalLocation(order.getFinalLocation());
        orderDTO.setStatusOrder(order.getStatusOrder());
        orderDTO.setInitialLocation(order.getInitialLocation());
        return orderDTO;
    }
}
