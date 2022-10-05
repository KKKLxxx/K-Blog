import request from '@/utils/request'

export function getAll(params) {
  return request({
    url: '/article/getAll',
    method: 'get',
    params
  })
}

export function getDetail(params) {
  return request({
    url: '/article/getDetail',
    method: 'get',
    params
  })
}
