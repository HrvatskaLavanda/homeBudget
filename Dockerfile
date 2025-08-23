FROM postgres
ENV POSTGRES_DB='homebudget'
COPY initial_data.sql /docker-entrypoint-initdb.d/