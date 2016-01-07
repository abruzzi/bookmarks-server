package org.icodeit.bookmarks.service;

import org.icodeit.bookmarks.model.Feed;
import org.icodeit.bookmarks.model.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedsService {
    @Autowired
    private FeedRepository feedRepository;

    public Iterable<Feed> allFeeds() {
        return feedRepository.findAll();
    }

    public Feed saveFeed(Feed feed) {
        return feedRepository.save(feed);
    }
}
