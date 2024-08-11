from fastapi import FastAPI, HTTPException, Depends, status
from pydantic import BaseModel
from typing import Annotated
import models
from database import engine, SessionLocal
from sqlalchemy.orm import Session
from fastapi.middleware.cors import CORSMiddleware
from sqlalchemy import text
from passlib.context import CryptContext

app = FastAPI()
models.Base.metadata.create_all(bind = engine)
pwd_context = CryptContext(schemes=["bcrypt"], deprecated="auto")

origins = [
    "http://localhost:3000",
    "http://localhost:8000",
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

class GridBase(BaseModel):
    index: int
    position: int
    occupied: str
    color: str


def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()
db_dependency = Annotated[Session, Depends(get_db)]

@app.get("/grid/full/", status_code = status.HTTP_200_OK)
async def get_grid(db: db_dependency):
    db_grid = db.query(models.Grid).all()
    return {"grid" : db_grid}

@app.post("/grid/update/", status_code= status.HTTP_201_CREATED)
async def post_cell(cell: GridBase, db: db_dependency):
    db_cell = db.query(models.Grid).filter(models.Grid.position == cell.position).first()

    if (db_cell == None):
        db_cell = models.Grid(**cell.dict())
        db.add(db_cell)
        db.commit()
        
    else:
        db_cell.color = cell.color
        db_cell.occupied = cell.occupied
        db.commit()
        db.refresh(db_cell)
    return cell
