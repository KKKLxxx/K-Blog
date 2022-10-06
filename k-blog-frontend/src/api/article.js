import request from '@/utils/request'

export function getAll(params) {
  return request({
    url: '/article/getAll',
    method: 'get',
    params
  })
}

export function getById(params) {
  return request({
    url: '/article/getById',
    method: 'get',
    params
  })
}
