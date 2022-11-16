package com.kviz.jnews.job;

import com.kviz.jnews.model.News;
import com.kviz.jnews.service.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Log4j2
public class ParserTask {

    private final NewsService newsService;

    @Scheduled(fixedDelay = 10000)
    public void parseNewNews() {
        log.info(">>> parseNewNews");
        var url = "https://news.ycombinator.com/";
        try {
            Jsoup.connect(url)
                    .userAgent("Google")
                    .timeout(5000)
                    .referrer("http://google.com")
                    .get()
                    .getElementsByClass("titleline")
                    .stream()
                    .filter(element -> !newsService.isExist(element.child(0).ownText()))
                    .forEach(element -> newsService.save(new News()
                            .setTitle(element.child(0).ownText())
                            .setHref(element.child(0).attributes().get("href"))));
        } catch (IOException e) {
            log.error("Parse new news exception: {} ", e.getMessage());
        }
        log.info("<<< parseNewNews");
    }
}
