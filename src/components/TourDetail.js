import { useEffect, useState } from "react";
import React from "react";
import Apis, { endpoints } from "../configs/Apis";
import { useParams } from "react-router-dom";
import "../style/tourDetail.css";

const TourDetail = () => {
  const { tourId } = useParams();
  const [tour, setTour] = useState(null);
  const [err, setErr] = useState(false);

  const [comments, setComments] = useState([]);
  const [newComment, setNewComment] = useState('');

  // Hàm xử lý khi người dùng thêm bình luận
  const handleAddComment = () => {
    if (newComment.trim() !== '') {
      setComments([...comments, newComment]);
      setNewComment('');
    }
  };



  const addToCard = () => {
    window.location.href = "/checkout";
  };
  useEffect(() => {
    const loadData = async () => {
      let endpoint = `${endpoints["tour"]}${tourId}/`;
      console.log(endpoint);
      let res = await Apis.get(endpoint);

      if (res.status == 200) {
        setTour(res.data);
        setErr(true);
        console.log(res.data);
      } else {
        console.log("erroor");
      }
    };

    loadData();
  }, []);

  const [rating, setRating] = useState(5);

  return (
    <>
      {err ? (
        <div className="body-content">
          <div className="image-tour">
            <img src={tour.imageCover} alt={tour.imageCover}></img>
          </div>
          <div className="row">
            <div className="col-md-7 col-12 left">
              <h1 className="title">{tour.tourName}</h1>

              <div className="rating">{rating} sao</div>
            </div>

            <div
              style={{ paddingLeft: "200px" }}
              className="col-md-5 col-12 left"
            >
              <div className="price">
                <span>{tour.price} đ </span> / khách
              </div>
              <div class="group-add-card">
                <a className="add-to-card" onClick={addToCard}> Đặt ngay
                </a>
                <a className="support">Liên hệ tư vấn</a>
              </div>
            </div>
          </div>
          {/* Info tour detail */}
          <div className="container">
            <div className="row">
              <div className="col-md-5 col-12 left">
                <div className="order-box">
                  <div className="time-tour">
                    <p>Khởi hành: {tour.startTour}</p>
                    <p>Tập trung: {tour.concentrate} </p>
                    <p>Thời gian: {tour.timeTour} </p>
                    <p>Nơi khởi hành: {tour.startingGate} </p>
                    <p>Số chỗ còn nhận: {tour.numberOfSeatsAvailable}</p>
                  </div>
                </div>
              </div>
              <div className="col-md-7 col-12 left">
                <div class="group-services">
                  <div class="item">
                    <i class="fa-regular fa-calendar"></i>
                    <label>Thời gian</label>
                    <p>{tour.timeTour}</p>
                  </div>

                  <div class="item">
                    <i class="fa-solid fa-car"></i>
                    <label>Phương tiện</label>
                    <p>{tour.transport}</p>
                  </div>

                  <div class="item">
                    <i class="fa-solid fa-flag"></i>
                    <label>Địa điểm tham quan</label>
                    <p>{tour.sightSeeing}</p>
                  </div>

                  <div class="item">
                    <i class="fa-solid fa-utensils"></i>
                    <label>Ẩm thực</label>
                    <p>{tour.cuisine}</p>
                  </div>

                  <div class="item">
                    <i class="fa-solid fa-hotel"></i>
                    <label>Nơi ở</label>
                    <p>{tour.hotel}</p>
                  </div>

                  <div class="item">
                    <i class="fa-solid fa-heart"></i>
                    <label>Phù hợp</label>
                    <p>{tour.suitableSubject}</p>
                  </div>
                </div>
              </div>
            </div>
          </div>

          {/* Lịch trình */}
          <section className="container">
            <h2 className="title">Lịch trình</h2>
            <p className="text-info">{tour.schedule}</p>
          </section>

          {/* Comment */}
          <div>
            <h2 className="title">Tất cả đánh giá</h2>
            <ul>
              {comments.map((comment, index) => (
                <li key={index}>{comment}</li>
              ))}
            </ul>
            <div>
              <textarea
                rows="4"
                cols="50"
                placeholder="Thêm bình luận..."
                value={newComment}
                onChange={(e) => setNewComment(e.target.value)}
              ></textarea>
              <br />
              <button onClick={handleAddComment}>Thêm</button>
            </div>
          </div>
        </div>
      ) : (
        <div>tour-detail</div>
      )}
    </>
  );
};

export default TourDetail;
