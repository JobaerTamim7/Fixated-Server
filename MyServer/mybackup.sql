PGDMP                       }         
   restaurant    17.2    17.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    16532 
   restaurant    DATABASE     �   CREATE DATABASE restaurant WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE restaurant;
                     csedu29    false            �            1259    16534    users    TABLE       CREATE TABLE public.users (
    id integer NOT NULL,
    mail character varying(50) NOT NULL,
    name character varying(50) NOT NULL,
    password character varying(100) NOT NULL,
    role character varying(50) NOT NULL,
    phone_number character varying(12),
    worker_id character varying(20),
    branch_code character varying(3),
    CONSTRAINT check_role CHECK (((role)::text = ANY ((ARRAY['admin'::character varying, 'manager'::character varying, 'employee'::character varying, 'customer'::character varying])::text[])))
);
    DROP TABLE public.users;
       public         heap r       csedu29    false            �            1259    16533    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public               csedu29    false    218            �           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public               csedu29    false    217            �            1259    16551    users_id_seq1    SEQUENCE     �   ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               csedu29    false    218            �          0    16534    users 
   TABLE DATA           e   COPY public.users (id, mail, name, password, role, phone_number, worker_id, branch_code) FROM stdin;
    public               csedu29    false    218   ~       �           0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 33, true);
          public               csedu29    false    217            �           0    0    users_id_seq1    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq1', 4, true);
          public               csedu29    false    219            Z           2606    16544    users unique_name 
   CONSTRAINT     L   ALTER TABLE ONLY public.users
    ADD CONSTRAINT unique_name UNIQUE (name);
 ;   ALTER TABLE ONLY public.users DROP CONSTRAINT unique_name;
       public                 csedu29    false    218            \           2606    16542    users users_mail_key 
   CONSTRAINT     O   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_mail_key UNIQUE (mail);
 >   ALTER TABLE ONLY public.users DROP CONSTRAINT users_mail_key;
       public                 csedu29    false    218            ^           2606    16540    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public                 csedu29    false    218            �   `   x�3���OJL-*I���5wH�M���K���p���q&����q��A��Fct�Ƹ5#k4E׈[�	�>�Z@��l##,�c���� �J�     