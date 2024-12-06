import request from '@/utils/request'
import { useTokenStore } from '@/stores/token'

export const flightListService =()=>{
    const tokenStore = useTokenStore()
    // return request.get('/airportView/aircraftList',{headers: {'Authorization': tokenStore.token}})
    //因为在request。js中设置了默认的headers，所以这里可以不用设置headers
    return request.get('/airportView/flightList')
}
export const flightAddService = (data)=>{
    return request.post('/airportView/addFlight',data)
}
export const flightDeleteService = (id)=>{
    return request.delete('/airportView/deleteFlight/'+id)
}
export const flightUpdateService = (data)=>{
    return request.put('/airportView/updateFlight',data)
}
