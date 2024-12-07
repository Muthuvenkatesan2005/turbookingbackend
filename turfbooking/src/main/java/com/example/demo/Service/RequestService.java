//
//package com.example.demo.Service;
//
//import com.example.demo.Model.RequestModel;
//import com.example.demo.Repository.RequestRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class RequestService {
//
//    @Autowired
//    private RequestRepository requestRepository;
//
//    public List<RequestModel> getAllRequests() {
//        return requestRepository.findAll();
//    }
//
//    public Optional<RequestModel> getRequestById(Long id) {
//        return requestRepository.findById(id);
//    }
//
//    public RequestModel createRequest(RequestModel request) {
//        return requestRepository.save(request);
//    }
//
//    public RequestModel updateRequest(Long id, RequestModel requestDetails) {
//        RequestModel request = requestRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Request not found for this id :: " + id));
//        request.setName(requestDetails.getName());
//        request.setDate(requestDetails.getDate());
//        request.setTime(requestDetails.getTime());
//        request.setHours(requestDetails.getHours());
//        return requestRepository.save(request);
//    }
//
//    public void deleteRequest(Long id) {
//        RequestModel request = requestRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Request not found for this id :: " + id));
//        requestRepository.delete(request);
//    }
//}
