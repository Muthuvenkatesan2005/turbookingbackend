//
//package com.example.demo.Controller;
//
//import com.example.demo.Model.RequestModel;
//import com.example.demo.Service.RequestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/requests")
//@CrossOrigin(origins = "http://localhost:3000")
//public class RequestController {
//
//    @Autowired
//    private RequestService requestService;
//
//    @GetMapping
//    public ResponseEntity<List<RequestModel>> getAllRequests() {
//        List<RequestModel> requests = requestService.getAllRequests();
//        return ResponseEntity.ok(requests);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<RequestModel> getRequestById(@PathVariable Long id) {
//        Optional<RequestModel> request = requestService.getRequestById(id);
//        return request.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<RequestModel> createRequest(@RequestBody RequestModel request) {
//        RequestModel createdRequest = requestService.createRequest(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<RequestModel> updateRequest(@PathVariable Long id, @RequestBody RequestModel requestDetails) {
//        RequestModel updatedRequest = requestService.updateRequest(id, requestDetails);
//        return ResponseEntity.ok(updatedRequest);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
//        requestService.deleteRequest(id);
//        return ResponseEntity.noContent().build();
//    }
//}
