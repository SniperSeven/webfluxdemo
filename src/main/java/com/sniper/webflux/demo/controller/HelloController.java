package com.sniper.webflux.demo.controller;

import com.sniper.webflux.demo.module.Hello;
import com.sniper.webflux.demo.repository.HelloRepository;
import com.sniper.webflux.demo.repository.HelloRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @author Chengyafeng
 * @date 2022/02/12 23:49
 **/
@RestController
public class HelloController {
    @Autowired
    private HelloRepository repository;

    @Autowired
    private HelloRepository2 repository2;

    @RequestMapping("/hello")
    public Mono<Integer> hello() {
        return repository.findById(Mono.just("sniper")).map(Hello::getAge);
    }

    @RequestMapping("/hello2")
    public Mono<Integer> hello2() {
        return repository2.getOne("sniper").map(Hello::getAge);

    }

    @RequestMapping(value = "/upload")
    public Mono<List<String>> upload(@RequestPart("file") Flux<FilePart> filePartFlux) {
        return filePartFlux.map(filePart -> {
            Path tmpFile = null;
            try {
                tmpFile = Files.createTempFile("mfile-", filePart.filename());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(tmpFile.toAbsolutePath());

            // 对每个filePart执行写文件的方法
            filePart.transferTo(tmpFile.toFile());

            // 返回Path对象
            return tmpFile;
        }).map(Path::toFile).flatMap(fileSingle -> filePartFlux.map(FilePart::filename)).collectList();
    }
}
