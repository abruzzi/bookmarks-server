package org.icodeit.bookmarks.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.icodeit.bookmarks.model.Feed;
import org.icodeit.bookmarks.service.FeedsService;
import org.icodeit.bookmarks.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class FeedsControllerTest {
    private MockMvc mockMvc;
    private FeedsService feedsService;
    private UserService userService;

    @Before
    public void setup() {
        feedsService = mock(FeedsService.class);
        userService = mock(UserService.class);

        FeedsController feedsController = new FeedsController();
        feedsController.setFeedsService(feedsService);
        feedsController.setUserService(userService);

        mockMvc = standaloneSetup(feedsController).build();
    }

    @Test
    public void shouldResponseWithAllFeeds() throws Exception {
        when(feedsService.allFeeds()).thenReturn(Arrays.asList(prepareFeeds()));

        mockMvc.perform(get("/api/feeds"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].publishDate", is(notNullValue())));
    }

    @Test
    public void shouldResponseWithUsersFavoriteFeeds() throws Exception {
        when(userService.favoriteFeeds(any(Long.class))).thenReturn(Arrays.asList(prepareFavoriteFeeds()));

        mockMvc.perform(get("/api/fav-feeds/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is("使用underscore.js构建前端应用")))
                .andExpect(jsonPath("$[0].publishDate", is(notNullValue())));
    }

    private Feed[] prepareFeeds() throws IOException {
        URL resource = getClass().getResource("/mocks/feeds.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource, Feed[].class);
    }

    private Feed[] prepareFavoriteFeeds() throws IOException {
        URL resource = getClass().getResource("/mocks/fav-feeds.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource, Feed[].class);
    }
}