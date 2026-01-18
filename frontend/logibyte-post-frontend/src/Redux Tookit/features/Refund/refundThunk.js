import { getAuthHeaders } from "@/util/getAuthHeader";
import { createAsyncThunk } from "@reduxjs/toolkit";
import api from "@/util/api";

export const createRefund = createAsyncThunk(
  "/refund/create",
  async (refundDTO, { rejectWithValue }) => {
    try {
      const headers = getAuthHeaders();

      const res = await api.post("/api/refunds", refundDTO, { headers });

      console.log("create refund success", res.data);
      return res.data;
    } catch (error) {
      console.log("error", error);
      return rejectWithValue(
        error.response?.data?.message || "Failed to create refund ",
      );
    }
  },
);

export const getAllRefund = createAsyncThunk(
  "/refund/getAll",
  async (_, { rejectWithValue }) => {
    try {
      const headers = getAuthHeaders();

      const res = await api.get("/api/refunds", { headers });

      console.log("get All refund success", res.data);
      return res.data;
    } catch (error) {
      console.log("error", error);
      return rejectWithValue(
        error.response?.data?.message || "Failed to get all refunds ",
      );
    }
  },
);

export const getRefundsByCashier = createAsyncThunk(
  "/refund/getByCashier",
  async (cashierId, { rejectWithValue }) => {
    try {
      const headers = getAuthHeaders();

      const res = await api.get(`/api/refunds/cashier/${cashierId}`, {
        headers,
      });

      console.log("get refund by cashier success", res.data);
      return res.data;
    } catch (error) {
      console.log("error", error);
      return rejectWithValue(
        error.response?.data?.message || "Failed to create refund ",
      );
    }
  },
);

export const getRefundsById = createAsyncThunk(
  "/refund/getById",
  async (refundId, { rejectWithValue }) => {
    try {
      const headers = getAuthHeaders();

      const res = await api.get(`/api/refunds/${refundId}`, {
        headers,
      });

      console.log("get refund by id success", res.data);
      return res.data;
    } catch (error) {
      console.log("error", error);
      return rejectWithValue(
        error.response?.data?.message || "Failed to get refund by id ",
      );
    }
  },
);

export const getRefundsByShift = createAsyncThunk(
  "/refund/getByShift",
  async (shiftReportId, { rejectWithValue }) => {
    try {
      const headers = getAuthHeaders();

      const res = await api.get(`/api/refunds/shift/${shiftReportId}`, {
        headers,
      });

      console.log("get refund by shift success", res.data);
      return res.data;
    } catch (error) {
      console.log("error", error);
      return rejectWithValue(
        error.response?.data?.message || "Failed to get shift refund ",
      );
    }
  },
);

export const getRefundsByCashierAndDateRange = createAsyncThunk(
  "/refund/getByCashierAndDateRange",
  async ({ cashierId, from, to }, { rejectWithValue }) => {
    try {
      const headers = getAuthHeaders();

      const formattedFrom = encodeURIComponent(from);
      const formattedTo = encodeURIComponent(to);

      const res = await api.get(
        `/api/refunds/cashier/${cashierId}/range?from=${formattedFrom}&to=${formattedTo}`,
        {
          headers,
        },
      );

      console.log("get by date range success", res.data);
      return res.data;
    } catch (error) {
      console.log("error", error);
      return rejectWithValue(
        error.response?.data?.message || "Failed to refund ",
      );
    }
  },
);
