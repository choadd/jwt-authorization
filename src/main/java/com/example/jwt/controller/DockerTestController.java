package com.example.jwt.controller;


import com.example.jwt.model.Test;
import com.example.jwt.repository.TestRepository;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
public class DockerTestController {

    private final TestRepository testRepository;

    @GetMapping("/docker-test")
    public ResponseEntity<List<Test>> dockerTest(){
        return new ResponseEntity<List<Test>>(testRepository.findAll(), HttpStatus.OK);
    }

    public static void main(String[] args) {
        int arr[];
        int arrlen = arr.length;

        arr = Arrays.stream(arr).distinct().toArray();
        Arrays.sort(arr);
        if(arrlen==arr.length){
            for(int i=0; i<arrlen; i++){
                if(i==arr[i]){

                }else{
                }
            }
        }


    }

}
