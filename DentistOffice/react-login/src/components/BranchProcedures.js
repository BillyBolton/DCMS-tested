import React, {useEffect, useState} from "react";
import axios from "axios";
import {List} from "semantic-ui-react";
import {useParams} from "react-router-dom";

const BranchProcedures = () => {
    const {id} = useParams();
    const[procedures, SetProcedures] = useState([]);

    const fetchProcedures = async () => {
        try {
            const {data} = await axios.get(`http://localhost:8080/branch/findById?id=${id}`);
            SetProcedures(data.procedures);

        } catch (err) {
            console.error(err);
        }
    };

    useEffect(() => {
        fetchProcedures();
    }, []);

    //==== IF WE ENRICH ENDPOINT TO HAVE PROCEDURE DESCRIPTIONS ====
    // const panels = procedures.map((procedure) => ({
    //         key: procedure.id,
    //         title: procedure.type,
    //         content: procedure.description
    //     }
    //     ));

    function toTitleCase(str) {
        return str.replace(
            /\w\S*/g,
            function(txt) {
                return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
            }
        );
    }

    return (
        <List>
            {procedures.map((procedure) => (
                <List.Item><List.Icon name='plus'/>{toTitleCase(procedure.type.replace("_"," "))}</List.Item>
            ))}
        </List>
    )

}

export default BranchProcedures;