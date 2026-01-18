import {
  createOrder,
  deleteOrder,
  getOrdersByCashier,
  getOrderByCustomer,
  getOrderById,
  getOrdersByBranch,
  getRecentOrdersByBranch,
  getTodayOrdersByBranch,
} from "./orderThunk";
import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  orders: [],
  todayOrders: [],
  customerOrders: [],
  selectedOrder: null,
  recentOrders: [],
  loading: false,
  error: null,
};

const orderSlice = createSlice({
  name: "order",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(createOrder.pending, (state) => {
        state.loading = true;
      })
      .addCase(createOrder.fulfilled, (state, action) => {
        ((state.loading = false), state.orders.push(action.payload));
      })
      .addCase(createOrder.rejected, (state, action) => {
        ((state.loading = false), (state.error = action.payload));
      })

      .addCase(getOrderById.fulfilled, (state, action) => {
        state.selectedOrder = action.payload;
      })
      .addCase(getOrdersByBranch.fulfilled, (state, action) => {
        state.orders = action.payload;
      })

      .addCase(getOrdersByCashier.fulfilled, (state, action) => {
        state.orders = action.payload;
        console.log("get order by cashier", action.payload);
      })
      .addCase(getTodayOrdersByBranch.fulfilled, (state, action) => {
        state.todayOrders = action.payload;
      })
      .addCase(getOrderByCustomer.fulfilled, (state, action) => {
        state.customerOrders = action.payload;
      })
      .addCase(getRecentOrdersByBranch.fulfilled, (state, action) => {
        state.recentOrders = action.payload;
      })
      .addCase(deleteOrder.fulfilled, (state, action) => {
        state.orders = state.orders.filter((o) => o.id !== action.payload);
      });
  },
});

export default orderSlice.reducer;
