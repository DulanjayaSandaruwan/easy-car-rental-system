import React from "react";
import {Col, Container, Row} from "reactstrap";
import "../../styles/about-section.css";
import aboutImg from "../../assets/all-images/cars-img/bmw-offer.png";

const AboutSection = ({aboutClass}) => {
    return (
        <section
            className="about__section"
            style={
                aboutClass === "aboutPage"
                    ? {marginTop: "0px"}
                    : {marginTop: "280px"}
            }
        >
            <Container>
                <Row>
                    <Col lg="6" md="6">
                        <div className="about__section-content">
                            <h4 className="section__subtitle">About Us</h4>
                            <h2 className="section__title">Welcome to the Easy car rent service</h2>
                            <p className="section__description">
                                There's nothing quite like exploring a new destination by car ...
                                Hiring a car is an ever-popular way to travel, both for business and leisure. But with
                                so many different companies to choose from it can be hard to know which one is right for
                                you. That's where easyCar comes in. We've helped millions of customers find the perfect
                                car for their holiday, whether it's an SUV in the Canaries, a compact car in Central
                                London, or anything else in between.
                                Our mission is to provide our customers with a smooth car rental journey from the first
                                click of the mouse to the last click of the keys.
                                No hidden fees, no dodgy Ts&Cs.
                            </p>

                            <div className="about__section-item d-flex align-items-center">
                                <p className="section__description d-flex align-items-center gap-2">
                                    <i class="ri-checkbox-circle-line"></i> Biggest car hire in the Sri Lanka
                                </p>

                                <p className="section__description d-flex align-items-center gap-2">
                                    <i class="ri-checkbox-circle-line"></i> Important extras are included in price
                                </p>
                            </div>

                            <div className="about__section-item d-flex align-items-center">
                                <p className="section__description d-flex align-items-center gap-2">
                                    <i class="ri-checkbox-circle-line"></i> Available 24/7
                                </p>

                                <p className="section__description d-flex align-items-center gap-2">
                                    <i class="ri-checkbox-circle-line"></i> Personalise your booking with ease
                                </p>
                            </div>
                        </div>
                    </Col>

                    <Col lg="6" md="6">
                        <div className="about__img">
                            <img src={aboutImg} alt="" className="w-100"/>
                        </div>
                    </Col>
                </Row>
            </Container>
        </section>
    );
};

export default AboutSection;
