import { BrowserRouter, Route, Routes } from "react-router-dom";
import Footer from "./layout/Footer";
import Header from "./layout/Header";
import Home from "./layout/Home";
import "bootstrap/dist/css/bootstrap.min.css";
import Login from "./components/Login";
import Tour from "./components/Tour";
import TourDetail from "./components/TourDetail";
import TourByCate from "./components/TourByCate";
import MyUserReducer from "./reducers/MyUserReducer";
import { createContext, useReducer } from "react";
import cookie from "react-cookies";
import { Container } from "react-bootstrap";
import News from "./components/News";
import NewsDetail from "./components/NewsDetail";

export const MyUserContext = createContext();

const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);

  return (
    <>
      <MyUserContext.Provider value={[user, dispatch]}>
        <BrowserRouter>
          <Header />
          <Container>
            <Routes>
              <Route path="/" element={<Home />}></Route>
              <Route path="/login" element={<Login />}></Route>
              <Route path="/news" element={<News />}></Route>
              <Route path="/tours" element={<Tour />}></Route>
              <Route path="/tours/:tourId" element={<TourDetail />}></Route>
              <Route path="/news/:newsId" element={<NewsDetail />}></Route>
              <Route path="/tours/category/:cateId" element={<TourByCate />}></Route>
            </Routes>
          </Container>
          <Footer />
        </BrowserRouter>
      </MyUserContext.Provider>
    </>
  );
};
export default App;
