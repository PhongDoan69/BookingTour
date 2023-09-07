/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kyan2
 */
@Entity
@Table(name = "news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findById", query = "SELECT n FROM News n WHERE n.id = :id"),
    @NamedQuery(name = "News.findByTitle", query = "SELECT n FROM News n WHERE n.title = :title"),
    @NamedQuery(name = "News.findByPostDate", query = "SELECT n FROM News n WHERE n.postDate = :postDate")})
public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "postDate")
    @Temporal(TemporalType.DATE)
    private Date postDate;
    @JoinColumn(name = "postBy", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User postBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newsId")
    private Set<NewsImgae> newsImgaeSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newsId")
    private Set<Liked> likedSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newsId")
    private Set<Comment> commentSet;

    public News() {
    }

    public News(Integer id) {
        this.id = id;
    }

    public News(Integer id, String title, String content, Date postDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.postDate = postDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public User getPostBy() {
        return postBy;
    }

    public void setPostBy(User postBy) {
        this.postBy = postBy;
    }

    @XmlTransient
    public Set<NewsImgae> getNewsImgaeSet() {
        return newsImgaeSet;
    }

    public void setNewsImgaeSet(Set<NewsImgae> newsImgaeSet) {
        this.newsImgaeSet = newsImgaeSet;
    }

    @XmlTransient
    public Set<Liked> getLikedSet() {
        return likedSet;
    }

    public void setLikedSet(Set<Liked> likedSet) {
        this.likedSet = likedSet;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bkt.pojo.News[ id=" + id + " ]";
    }
    
}
