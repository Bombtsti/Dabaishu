import axios, { InternalAxiosRequestConfig, AxiosResponse } from "axios";
import { storage } from "./storage";
import { ElMessage } from "element-plus";
import { baseURL } from "@/constant/constant";
// 刷新 token 后, 将缓存的接口重新请求一次
// 是否正在刷新 token


// 创建 axios 实例
const service = axios.create({
  // baseURL: import.meta.env.VITE_APP_BASE_API,
  baseURL: baseURL,
  timeout: 50000,
  headers: { "Content-Type": "application/json;charset=utf-8" },
});

// 请求拦截器
service.interceptors.request.use(
  (config: InternalAxiosRequestConfig) => {

    if (storage.get('token')) {
      config.headers.token = storage.get('token');
    }
    return config;
  },
  (error: any) => {
    return Promise.reject(error);
  }
);

// 响应拦截器
service.interceptors.response.use(
  (response: AxiosResponse) => {
    const { code } = response.data;
    console.log(response, code);
    if (code === 200) {
      return response.data;
    }
    // 响应数据为二进制流处理(Excel导出)
    // if (response.data instanceof ArrayBuffer) {
    //   return response;
    // }
    ElMessage.error("登录失败");
    return Promise.reject(response.data);
  }
);

// 导出 axios 实例
export default service;
