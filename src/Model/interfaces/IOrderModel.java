package Model.interfaces;

import Model.dto.CreateOrderDto;
import Model.dto.UpdateOrderDto;
import Model.entities.Order;

import java.util.ArrayList;

public interface IOrderModel {

    public ArrayList<Order> getOrders();

    public void createOrder(CreateOrderDto createOrderDto);

    public void updateOrder(UpdateOrderDto updateOrderDto);

}
