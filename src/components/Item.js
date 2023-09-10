import { Card, Col, Row } from "react-bootstrap";
import { Link } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import axios from "axios";
import "../style/item.css";

const Item = ({ obj }) => {
  let tourName = `${obj.tourName}`;
  let newTN = tourName.substring(0, 100);

  return (
    <>
      <Card className="card">
        <Card.Img variant="top" src={obj.imageCover} className="card-img-top" />
        <Card.Body>
          <Card.Title className="title-obj" style={{ height: "150px" }}>
            {newTN}....
          </Card.Title>
          <Card.Text className="title-text">{obj.price} đ</Card.Text>

          <Row>
            <Link className="btn-details" to={`/tours/${obj.id}`}>
              Xem chi tiết
            </Link>
            <Col>
              <Link className="btn-buy " to={`/tours/${obj.id}`}>
                Đặt ngay
              </Link>
            </Col>
          </Row>
        </Card.Body>
      </Card>
      {/* <div >
                <div class="card">      
                    <img class="card-img-top" src={obj.imageCover} />
                    <div class="card-body">
                        <h4 class="card-title">{newTN}</h4>
                        <p class="card-text">
                            {obj.price}
                        </p>
                        <a href="#" class="btn btn-outline-primary">Xem chi tiết</a>             
                        <button class="btn btn-danger btn-buy" onclick="delTour('/bookingtour/api/tour/27')">Xóa</button>
                    </div>                    
                </div>
            </div> */}
    </>
  );
};

export default Item;
