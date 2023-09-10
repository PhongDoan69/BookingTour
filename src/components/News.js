import React, { useEffect, useState } from "react";
import "../style/news.css";
import { Link } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
const News = () => {
  const [news, setNews] = useState(null);

  useEffect(() => {
    const loadData = async () => {
      let res = await Apis.get(`${endpoints["news"]}`);

      if (res.status === 200) {
        setNews(res.data);
      }
    };

    loadData();
  }, [])

  return (
    <>
      <h2>Danh sách tin tức</h2>
      <div className="container col">
        {news != null ? (
          news.map((n) => (
            <article className="card">
              <Link className="news-container" to={`/news/${n.id}`}>
                <img
                  className="news-image"
                  src={n.imageCover}
                  alt={n.title}
                  class="news-image"
                />
                <h4 class="news-title">{n.title}</h4>
              </Link>
            </article>
          ))
        ) : (
          <div>Errorr</div>
        )}
        
      </div>
    </>
  );
};

export default News;
