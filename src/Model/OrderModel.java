package Model;

import Model.dto.CreateOrderDto;
import Model.dto.UpdateOrderDto;
import Model.entities.Order;
import Model.interfaces.IOrderModel;

import java.util.ArrayList;

public class OrderModel implements IOrderModel {


    @Override
    public ArrayList<Order> getOrders() {
        return null;
    }

    @Override
    public void createOrder(CreateOrderDto createOrderDto) {

    }

    @Override
    public void updateOrder(UpdateOrderDto updateOrderDto) {

    }
}
