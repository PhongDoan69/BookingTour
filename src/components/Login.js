import { useContext, useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import Apis, { authApi, endpoints } from "../configs/Apis";
import cookie from "react-cookies";
import { Navigate, useSearchParams } from "react-router-dom";
import { MyUserContext } from "../App";
const Login = () => {
  const [user, dispatch] = useContext(MyUserContext);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [q] = useSearchParams();

  const handleLogin = (evt) => {
    evt.preventDefault();

    let endpoint = `${endpoints["login"]}`;

    const process = async () => {
      try {
        let body = {
            "username": username,
            "password": password
          }

        let res = await Apis.post(endpoint, body);

        cookie.save("token", res.data);

        let { data } = await authApi().get(endpoints["current-user"]);
        cookie.save("user", data);

        dispatch({
          type: "login",
          payload: data,
        });
      } catch (err) {
        console.error(err);
      }
    };

    process();
  };

  if (user !== null) {
    let next = q.get("next") || "/";
    return <Navigate to={next} />;
  }

  return (
    <>
      <h1 className="text-center text-info ">Đăng nhập</h1>
      <Form onSubmit={handleLogin} style={{ margin: "0 20% 0 20%" }}>
        <Form.Group as={Row} className="mb-3 " controlId="formUsername">
          <Form.Label column sm="2">
            Tài khoản
          </Form.Label>
          <Col sm="10">
            <Form.Control
              value={username}
              onChange={(evt) => setUsername(evt.target.value)}
              type="text"
              placeholder="Tên đăng nhập..."
            />
          </Col>
        </Form.Group>

        <Form.Group as={Row} className="mb-3" controlId="formPassword">
          <Form.Label column sm="2">
            Mật khẩu
          </Form.Label>
          <Col sm="10">
            <Form.Control
              value={password}
              type="password"
              onChange={(evt) => setPassword(evt.target.value)}
              placeholder="Mật khẩu..."
            />
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="mb-3" controlId="formPassword">
          <Button
            style={{ marginLeft: "auto", marginRight: "auto" }}
            className="text-center right"
            variant="info"
            type="submit"
          >
            Đăng nhập
          </Button>
        </Form.Group>
      </Form>
    </>
  );
};
export default Login;
