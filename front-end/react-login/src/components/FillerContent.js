import React from "react";
import {Header, Image, Grid} from "semantic-ui-react";

const facilityText = "Our modern, state-of-the-art facilities reflect our dedication to the highest standard of care for our patients. From the moment you walk in our doors, you’ll feel comfortable and at ease knowing that your oral health is in expert hands. We’re happy to offer free parking and extended office hours to further add to your experience with us!";
const careText = "At Struck by Whitening, we go above and beyond to ensure the comfort and safety of each and every one of our patients. All of our procedures are performed with the highest of standards for cleanliness and patient care. Our expert staff’s commitment to ongoing education, combined with our state-of-the-art facilities ensure that your family’s safety is in the best possible hands.";
const safetyText = "Our goal is to deliver optimal results while providing the highest level of compassion and professionalism. We use the latest technology, state-of-the-art sterilization techniques, hospital-grade operating rooms, digital x-rays and ultrasonic equipment to ensure our patients receive the highest level of care possible. and we don’t settle for anything but the best.";

function FillerContent() {
    return (
        <>
            <Image rounded bordered src='https://dentaldocs.com/wp-content/uploads/ottawa-dental-clinics-1.jpg'/>
            <Header>About Us</Header>
                <p>Struck by Whitening has all of the services you need, in convenient locations across Canada. When it comes to your health, you should only rely on somebody you can trust. Our highly qualified team of Doctors has the dental experience and expertise necessary to provide an unmatched level of care that will exceed your expectations. As an owner-operated facility, our patients’ health and well-being is our top priority.</p>
            <Header> Our Facilities </Header>
            <p>{facilityText}</p>

            <Grid columns={2}>
                <Grid.Column>
                    <Header>Standard of Care</Header>
                    <p>{careText}</p>
                </Grid.Column>
                <Grid.Column>
                    <Header>Safety</Header>
                    <p>{safetyText}</p>
                </Grid.Column>
            </Grid>

        </>
    )
}

export default FillerContent;