import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"
import Apis, { endpoints } from "../configs/Apis"
import "../style/newsDetail.css";

const NewsDetail  = ()=>{
const {newsId} = useParams()
const [news , setNews] = useState(null)
const [err, setError] = useState(false)


useEffect(() => {
    const loadData = async () => {
      let endpoint = `${endpoints["news"]}${newsId}/`;
      console.log(endpoint);
      let res = await Apis.get(endpoint);

      if (res.status == 200) {
        setNews(res.data);
        setError(true);
        console.log(res.data);
      } else {
        console.log("erroor");
      }
    };

    loadData();
  }, []);
    return(
        <>
        {err ? (
        <div className="news-detail">
            <h2 className="text-info ">{news.title}</h2>
            <img className="img-news-detail" src={news.imageCover}></img>
            <p className="news-content">{news.content}</p>
        </div>
      ) : (
        <div>tour-detail</div>
      )}
        </>
    )
}

export default NewsDetail