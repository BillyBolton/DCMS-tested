import React, { useState, useEffect } from 'react';
import { useParams } from "react-router-dom";
import { Header, Image, Grid, List } from 'semantic-ui-react'
import axios from 'axios'
import BranchReview from './BranchReview'
import BranchProcedures from "./BranchProcedures";

const dentistPic = 'https://lipsondentalgroup.com/wp-content/uploads/staff-1-600x598-1.jpg'



const BranchDetails = () => {
    const { id } = useParams();

    const [profile, SetProfile] = useState({});
    const [address, SetAddress] = useState({});
    const [dentists, SetDentists] = useState([]);

    const fetchBranchDetails = async () => {
        try {
            const { data } = await axios.get(`http://localhost:8080/branch/find/byId?id=${id}`);
            SetProfile(data.manager.profile)
            SetAddress(data.address)
        } catch (err) {
            console.error(err);
        }
    };

    const fetchDentists = async () => {
        try {
            const { data } = await axios.get(`http://localhost:8080/employee/dentist/find/byBranchId?branchId=${id}`);
            SetDentists(data);
        } catch (err) {
            console.error(err);
        }
    }

    useEffect(() => {
        fetchBranchDetails();
        fetchDentists();
        //console.log(branch)
    }, []);

    return (
        <Grid>
            <Grid.Row>
                <Header size="huge">{profile.lastName} Family Dental</Header>
            </Grid.Row>
            <Grid.Row>
                <Grid.Column width={6}>
                    <Image bordered src={dentistPic} />
                </Grid.Column>
                <Grid.Column width={6}>
                    <Header>Contact</Header>
                    <p>Phone: 1-800-TOOTH</p>
                    <p>Address: {address.buildingNumber} {address.street}, {address.city}, {address.province} {address.postalCode}</p>

                    <Header>Our Team</Header>
                    <List horizontal>
                        <List.Item>
                            <Image avatar src='https://cdn.iconscout.com/icon/free/png-256/business-1659524-1410046.png' />
                            <List.Content>
                                <List.Header>{profile.firstName} {profile.lastName}</List.Header>
                                Manager
                            </List.Content>
                        </List.Item>
                        {dentists.map((dentist) => (
                            <List.Item>
                                <Image avatar src='https://cdn.iconscout.com/icon/free/png-256/dentist-1659517-1410039.png' />
                                <List.Content>
                                    <List.Header>Dr. {dentist.profile.firstName} {dentist.profile.lastName}</List.Header>
                                    Dentist
                                </List.Content>
                            </List.Item>
                        ))}
                    </List>

                    <Header>Procedures</Header>
                    <BranchProcedures id={id} />


                    <BranchReview id={id} />
                </Grid.Column>
            </Grid.Row>
        </Grid>
    );
}

export default BranchDetails;