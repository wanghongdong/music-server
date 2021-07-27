package com.example.music.domain;

import java.io.Serializable;

public class ListSong implements Serializable {
    /**
     * 主键 id
     */
    private Integer id;

    /**
     * 歌曲id song_id
     */
    private Integer songId;

    /**
     * 歌单id song_list_id
     */
    private Integer songListId;

    /**
     * list_song
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @author wanghongdong
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @author wanghongdong
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 歌曲id
     * @author wanghongdong
     * @return song_id 
     */
    public Integer getSongId() {
        return songId;
    }

    /**
     * 歌曲id
     * @author wanghongdong
     * @param songId 
     */
    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    /**
     * 歌单id
     * @author wanghongdong
     * @return song_list_id 
     */
    public Integer getSongListId() {
        return songListId;
    }

    /**
     * 歌单id
     * @author wanghongdong
     * @param songListId 
     */
    public void setSongListId(Integer songListId) {
        this.songListId = songListId;
    }
}