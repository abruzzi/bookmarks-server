package org.icodeit.bookmarks.controller;

import org.icodeit.bookmarks.model.Feed;
import org.icodeit.bookmarks.service.FeedsService;
import org.icodeit.bookmarks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class FeedsController {

    @Autowired
    private FeedsService feedsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/feeds", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Feed> allFeeds() {
        return feedsService.allFeeds();
    }


    @RequestMapping(value="/fav-feeds/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Feed> favFeeds(@PathVariable("userId") Long userId) {
        System.err.println(userId);
        return userService.favoriteFeeds(userId);
    }
}
