import { Carousel } from "react-bootstrap"
import News from "../components/News"


const Home = ()=> {
    return(
        <>
        <div style={{margin: "0 10% 0 10%"}}>
        <img style={{height: "350px", width: "100%"}} src="https://images.unsplash.com/photo-1500964757637-c85e8a162699?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1806&q=80"/>
        <div style={{height: "100px"}}></div>
        <h3>TIN TỨC DU LỊCH</h3>
       
        <Carousel >
            <Carousel.Item interval={1000}>
                <img style={{ height:"200px"}}
                className="d-block w-100"
                src="https://images.unsplash.com/photo-1678393809235-7409bcc08d86?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8dG91ciUyMHZpZXQlMjBuYW18ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&w=500&q=60"
                alt="First slide"
                />
                <Carousel.Caption>
                <h3>First slide label</h3>
                <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item interval={500}>
                <img style={{ height:"200px"}}
                className="d-block w-100"
                src="logo512.png"
                alt="Second slide"
                />
                <Carousel.Caption>
                <h3>Second slide label</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                <img style={{ height:"200px"}}  
                className="d-block w-100"
                src="logo512.png"
                alt="Third slide"
                />
                <Carousel.Caption>
                <h3>Third slide label</h3>
                <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                </Carousel.Caption>
            </Carousel.Item>    
        </Carousel>
        </div>
        </>
    )
}
export default Home 