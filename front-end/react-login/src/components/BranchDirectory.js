import React, {useEffect, useState} from 'react'
import {Card, Header, Image} from 'semantic-ui-react'
import axios from 'axios'


const BranchDirectory = () => {
    const [branches, setBranches] = useState([]);

    useEffect(()=>{
        const fetch = async () => {
            try {
                const {data} = await axios.get("http://localhost:8080/branch/findAll");
                setBranches(data);
            } catch (err) {
                console.error(err);
            }
        };
        fetch();
    }, []);


    return (
        <>
            <Header size ='huge'>Branch Directory</Header>
            <Card.Group>
                {branches.map((branch) => (
                    <Card href={`/branch/${branch.id}`}>
                        <Image src='https://images.squarespace-cdn.com/content/v1/5c59c031e666694359ad9dc7/1549558600182-A3A85U6YWLLJP0PX0BXF/Exterior.jpg?format=2500w'/>
                        <Card.Content>
                            <Card.Header>{branch.manager.profile.lastName} Family Dental</Card.Header>
                            <Card.Description> {branch.address.buildingNumber} {branch.address.street}, {branch.address.city}, {branch.address.province} {branch.address.postalCode}</Card.Description>
                        </Card.Content>
                    </Card>

                ))}
            </Card.Group>

        </>
    )

}

export default BranchDirectory;