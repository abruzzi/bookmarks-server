package org.icodeit.bookmarks.controller;

import org.icodeit.bookmarks.model.Feed;
import org.icodeit.bookmarks.service.FeedsService;
import org.icodeit.bookmarks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://bookmarks-frontend.s3-website-us-west-2.amazonaws.com")
public class FeedsController {

    @Autowired
    private FeedsService feedsService;

    @Autowired
    private UserService userService;

    public void setFeedsService(FeedsService feedsService) {
        this.feedsService = feedsService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/feeds", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Feed> allFeeds() {
        return feedsService.allFeeds();
    }

    @RequestMapping(value="/feeds", method = RequestMethod.POST)
    @ResponseBody
    public Feed addFeed(@RequestBody Feed feed) {
        return feedsService.saveFeed(feed);
    }


    @RequestMapping(value="/fav-feeds/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Feed> favFeeds(@PathVariable("userId") Long userId) {
        return userService.favoriteFeeds(userId);
    }
}
