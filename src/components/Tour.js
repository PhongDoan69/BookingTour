import React, { useEffect, useState } from "react"
import Apis, { endpoints } from "../configs/Apis"
import { Col, Container, Row } from "react-bootstrap"
import Item from "./Item"

const Tour = () => {
    
    const [tour, setTour] = useState(null)
    const [err, setErr] = useState(false)
   useEffect(() => {
    
        
        const loadData = async () => {
            
            let endpoint = `${endpoints['tour']}`
            let res = await Apis.get(endpoint)

            
            if(res.status == 200) {
                setTour(res.data)
                setErr(true)
                   
                console.log(res.data)
            }
        
        }
    
        loadData()
   }, [])

    return(
        <>
            <Container>
                <Row>
                    {err ? tour.map( t => (
                        <Col key={t.id.toString()}>
                            <Item obj={t}/>

                        </Col>
                    )) : <div>tour</div>}
                </Row>

            </Container>

        </>
        
    )
}
export default Tour