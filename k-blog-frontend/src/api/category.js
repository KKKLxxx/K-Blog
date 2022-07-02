import request from '@/utils/request'

export function getAll() {
  return request({
    url: '/category/getAll',
    method: 'get'
  })
}
