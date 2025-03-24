package dev.ludwig.streams_schedule.repository;

import dev.ludwig.streams_schedule.exception.LiveStreamNotFoundException;
import dev.ludwig.streams_schedule.model.LiveStream;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LiveStreamRepository {

    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository() {
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Building REST APIs with Spring Boot",
                """
                        Pretty cool
                        """,
                "https://www.twtich.tv/danvega",
                LocalDateTime.of(2022, 2, 16, 11, 0),
                LocalDateTime.of(2022, 2, 16, 12, 0)
        ));
    }

    public List<LiveStream> findAll() {
        return streams;
    }

    public LiveStream findById(String id) throws LiveStreamNotFoundException {
        return streams.stream().filter(stream -> stream.id().equals(id)).findFirst().orElseThrow(LiveStreamNotFoundException::new);
    }

    public LiveStream create(LiveStream stream) {
        streams.add(stream);
        return stream;
    }

    public void update(LiveStream stream, String id) {
        LiveStream existing = streams.stream().filter(s -> s.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Stream not found"));
        int i = streams.indexOf(existing);
        streams.set(i, stream);
    }

    public void delete(String id) {
        streams.removeIf(stream -> stream.id().equals(id));
    }

}