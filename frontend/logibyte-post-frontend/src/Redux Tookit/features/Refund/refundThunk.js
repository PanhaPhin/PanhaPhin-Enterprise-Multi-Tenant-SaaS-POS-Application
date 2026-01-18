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

export const getRefundsByBranch = createAsyncThunk(
  "/refund/getByBranch",
  async (branchId, { rejectWithValue }) => {
    try {
      const headers = getAuthHeaders();

      const res = await api.get(`/api/refunds/branch/${branchId}`, {
        headers,
      });

      console.log("get refund by branch success", res.data);
      return res.data;
    } catch (error) {
      console.log("error", error);
      return rejectWithValue(
        error.response?.data?.message || "Failed to branch refund ",
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
