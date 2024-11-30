import request from '@/utils/request'

export const aircraftListService =()=>{
    return request.get('/companyView/list')
}
export const aircraftAddService = (data)=>{
    return request.post('/companyView/aircraft_add',data)
}
export const aircraftDeleteService = (id)=>{
    return request.delete('/companyView/aircraft_delete/'+id)
}
export const aircraftUpdateService = (data)=>{
    return request.put('/companyView/aircraft_update',data)
}
export const routesListService =()=>{
    return request.get('/companyView/routes_add')}
export const routesAddService = (data)=>{
    return request.post('/companyView/routes_add',data)
}
export const routesDeleteService = (id)=>{
    return request.delete('/companyView/routes_delete/'+id)
}
export const routesUpdateService = (data)=>{
    return request.put('/companyView/routes_update',data)
}