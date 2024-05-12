import request from "@/utils/request";
import {NoteDTO} from "@/type/note"

/**
 * 
 * @param currentPage 
 * @param pageSize 
 * @returns 
 */
export const getNotePage = (currentPage: number, pageSize: number) => {
  return request<any>({
    url: `/note/getNotePage/${currentPage}/${pageSize}`, // mock接口
    method: "get",
  });
};

/**
 * 
 * @param currentPage 
 * @param pageSize 
 * @param data 
 * @returns 
 */
export const getNotePageByDTO = (currentPage: number, pageSize: number, data:NoteDTO) => {
  return request<any>({
    url: `/note/getNotePageByDTO/${currentPage}/${pageSize}`, // mock接口
    method: "post",
    data: data
  });
};

/**
 * 
 * @param keyword 
 * @returns 
 */
export const getRecordByKeyWord = (keyword: string) => {
  return request<any>({
    url: `/search/record/getRecordByKeyWord`, // mock接口
    method: "get",
    params:{
      keyword
    }
  });
};

/**
 * 
 * @returns 
 */
export const getHotRecord = () => {
  return request<any>({
    url: `/search/record/getHotRecord`, // mock接口
    method: "get",
  });
};

/**
 * 
 * @param keyword 
 * @returns 
 */
export const addRecord = (keyword:string) => {
  return request<any>({
    url: `/search/record/addRecord`, // mock接口
    method: "get",
    params:{
      keyword
    }
  });
};