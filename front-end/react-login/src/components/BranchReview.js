import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom"
import axios from 'axios'
import {Header, Rating, Segment, Comment, List} from "semantic-ui-react";

const BranchReview = () => {
    const {id} = useParams();
    const [reviews, SetReviews] = useState([]);
    const [reviewAvgs, SetReviewAvgs] = useState([]);

    const fetchReviews = async () => {
        try {
            const {data} = await axios.get(`http://localhost:8080/review/findByBranchId?id=${id}`);
            SetReviews(data);

        } catch (err) {
            console.error(err);
        }
    };

    const fetchReviewAverages = async () => {
        try {
            const {data} = await axios.get(`http://localhost:8080/review/findAverageByBranchId?id=${id}`)
            SetReviewAvgs(data);
            console.log(data.professionalism);
        } catch (err) {
            console.error(err);
        }
    }

    useEffect(() => {
        fetchReviews();
        fetchReviewAverages();

    }, []);

    const datify = (dateString) => {
        const dateFormat = new Date(dateString);
        const prettyString = dateFormat.getDate()+'-'+dateFormat.getMonth()+'-'+dateFormat.getFullYear();
        return (prettyString)
    }

    console.log(reviewAvgs)
    return (
        <Segment>
            <Header>Rating</Header>
            <List divided verticalAlign='middle'>
                <List.Item>
                    <List.Content floated='right'><Rating disabled rating={reviewAvgs.professionalism} maxRating={5}/></List.Content>
                    <List.Icon name='handshake outline'/>
                    <List.Content>Professionalism</List.Content>
                </List.Item>
                <List.Item>
                    <List.Content floated='right'><Rating disabled rating={reviewAvgs.communication} maxRating={5}/></List.Content>
                    <List.Icon name='talk'/>
                    <List.Content>Communication</List.Content>
                </List.Item>
                <List.Item>
                    <List.Content floated='right'><Rating disabled rating={reviewAvgs.cleanliness} maxRating={5}/></List.Content>
                    <List.Icon name='paper plane outline'/>
                    <List.Content>Cleanliness</List.Content>
                </List.Item>
                <List.Item>
                    <List.Content floated='right'><Rating disabled rating={reviewAvgs.value} maxRating={5}/></List.Content>
                    <List.Icon name='dollar sign'/>
                    <List.Content>Value</List.Content>
                </List.Item>
            </List>

            <Comment.Group>
                <Header size="small" dividing>Reviews</Header>

                {reviews.map((review) => (
                    <Comment>
                        <Comment.Content>
                            <Comment.Author as='a'>{review.patient.profile.firstName} {review.patient.profile.lastName}</Comment.Author>
                            <Comment.Metadata>
                                {datify(review.date)}
                            </Comment.Metadata>
                            <Comment.Text>{review.comments}</Comment.Text>
                        </Comment.Content>
                    </Comment>

                ))}

            </Comment.Group>
        </Segment>
    )
}

export default BranchReview;