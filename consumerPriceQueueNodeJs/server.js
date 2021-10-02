// const express = require("express");
import express from "express";
import mongoose from "mongoose";


const app = express();


app.listen(3000, (err)=>{
    if(err){
        console.error(err);
    }
    console.log("app listening on port 3000...");
})
const dbURI = "mongodb:tcp://localhost:2717/testDB"
mongoose.connect(url, user, pass);

app.route("/")
.get((req,res)=>{
    console.log("here");
    console.log(req.statusCode);
    return "hello world";
})
.post((req, res)=>{
    let student = {
        name: "pedro",
        age:20
    }
    student = req.body;
    console.log(student);
    console.log("put request received")
    res.send();
});