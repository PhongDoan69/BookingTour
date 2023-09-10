import { useEffect, useState } from "react";
import {
  Button,
  Container,
  Form,
  Nav,
  NavDropdown,
  Navbar,
} from "react-bootstrap";

import { Link } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";

const Header = () => {
  const [categories, setCategories] = useState(null);

  useEffect(() => {
    const loadCates = async () => {
      let res = await Apis.get(endpoints["categories"]);
      setCategories(res.data);
    };
    loadCates();
  }, []);

  if (categories === null) return <h1> Loading... </h1>;
  return (
    <>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="/">Booking Tour</Navbar.Brand>
          <Navbar.Toggle aria-controls="navbarScroll" />
          <Navbar.Collapse id="navbarScroll">
            <Nav
              className="me-auto my-2 my-lg-0"
              style={{ maxHeight: "100px" }}
              navbarScroll
            >
              <Link className="nav-link" to="/tours">
                Tất cả
              </Link>

              <NavDropdown title="Du lịch" id="basic-nav-dropdown">
                {categories.map((c) => {
                  return (
                    <Link
                      className="dropdown-item"
                      to={`/tours/category/${c.id}`}
                      key={c.id}
                    >
                      {c.categoryName}
                    </Link>
                  );
                })}
              </NavDropdown>
              <Nav.Link href="/news">Tin tức</Nav.Link>
              <Nav.Link href="#2">Địa điểm du lịch gần bạn</Nav.Link>
            </Nav>
            <Form className="d-flex" style={{ marginLeft: "auto" }}>
              <Form.Control
                type="search"
                placeholder="Search"
                className="me-2"
                aria-label="Search"
              />
              <Button style={{ color: "#2d4271" }} variant="outline-success">
                Search
              </Button>
            </Form>

            <Link
              style={{ marginLeft: "10px" }}
              className="login nav-item"
              to="/login"
            >
              Đăng Nhập
            </Link>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </>
  );
};
export default Header;
