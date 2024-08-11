from sqlalchemy import Boolean, Column, Integer, String, Float
from database import Base

class Grid(Base):
	__tablename__ = "grid"

	index = Column(Integer, primary_key = True, index = False)
	position = Column(Integer)
	color = Column(String(1000))
	occupied = Column(String(1000))
